package com.tmb.controller;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmb.model.AccountDetails;
import com.tmb.model.AccountSummary;
import com.tmb.model.BankDetails;
import com.tmb.model.Book;
import com.tmb.model.FromAccountsList;
import com.tmb.model.PayeeAccountDetails;
import com.tmb.model.RSAPublicKeyBean;
import com.tmb.model.User;
import com.tmb.pojo.FundTransferInput;
import com.tmb.pojo.IFSCCodeSearch;
import com.tmb.pojo.Login;
import com.tmb.pojo.Status;
import com.tmb.service.TMBService;


@Controller
@RequestMapping("/")
public class ServiceController {

	HttpSession session;
	
	 User user;
     List<AccountDetails> accountDetailsList;
     
	@Autowired
    TMBService tMBService;
    

    static final Logger logger = Logger.getLogger(ServiceController.class);

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addBook(@RequestBody Book book){
        try{
        	tMBService.addBook(book);
            return new Status(1,"Book added");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Book getBookById(@PathVariable("id") long id){
        Book book = null;
        try {
            book = tMBService.getBookById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBookList() {
        List<Book> bookList = null;
        try {
            bookList = tMBService.getBookList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status deleteBook(@PathVariable("id") long id){
        try {
        	tMBService.deleteBook(id);
            return new Status(1,"book deleted");
        } catch (Exception e) {
            return new Status(0,e.toString());
        }
    }
    
    //Request for rsa public key from the client 
    @RequestMapping(value="/publickey", method = RequestMethod.GET)
    public @ResponseBody
    RSAPublicKeyBean getRSAPublicKey() throws NoSuchAlgorithmException
    {
    	return new RSAPublicKeyBean(tMBService.getRSAPublicKey());
    }
    
    

    @RequestMapping(value = "/createuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
   
    public @ResponseBody
    Status addUser(@RequestBody User user){
        try{
        	tMBService.addUser(user);
            return new Status(1,"User added");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }
   
    
    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User loginUser(@RequestBody Login login,HttpServletRequest request){
       
        try {
        	 session = request.getSession(true);
        	session.setAttribute("userid", login.getUserid());
            user = tMBService.getUserDetails(login.getUserid(),login.getPassword());
            accountDetailsList = tMBService.getUserAccountDetailsList(login.getUserid());
            session.setAttribute("user", user);
            session.setAttribute("accountDetailsList", accountDetailsList);
            System.out.println("User Details sasved in session object user       #######################################################"+session.getAttribute("user"));
            System.out.println("Account details List saved in session object accountDetailsList       $$$$$$$$$$$$$$$$$$$$$$#######################################################"+session.getAttribute("accountDetailsList"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    
    
    @RequestMapping(value="/getaccountdetails", method = RequestMethod.GET)
    public @ResponseBody
    List<AccountDetails> getUserAccountDetailsList(){
    	List<AccountDetails> userAccountDetailsList = null;
        try {
        	if(session!=null&&session.getAttribute("userid")!=null)
        	{
        	String userid = (String)session.getAttribute("userid");
        	userAccountDetailsList = tMBService.getUserAccountDetailsList(userid);
        System.out.println("if part$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+userAccountDetailsList);
        	}
        	else
        	{
        		userAccountDetailsList = tMBService.getUserAccountDetailsList("elavarasan");
        		 System.out.println("else part$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+userAccountDetailsList);
        	}
        }
        	catch (Exception e) {
                e.printStackTrace();
            }
        	
        return userAccountDetailsList;
    }
    @RequestMapping(value = "/createaccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    
    public @ResponseBody
    Status createAccount(@RequestBody AccountDetails accountDetails){
        try{
        	tMBService.createAccount(accountDetails);
            return new Status(1,"Account  added");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }
    @RequestMapping(value="/accountsummary", method = RequestMethod.GET)
    public @ResponseBody
    AccountSummary getAccountSummary(){

    	AccountSummary accountSummary = null;
        try {
        	if(session!=null)
        	{
        	String name = (String) session.getAttribute("userid");
        	accountSummary = tMBService.getAccountSummary(name);
        	System.out.println("session is not null####################################################");
        	}
        	else
        	{
        		System.out.println("session is null####################################################");
        		accountSummary = tMBService.getAccountSummary("vicky");
        	}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountSummary;
    }
    
 @RequestMapping(value = "/addpayee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    
    public @ResponseBody
    Status addPayee(@RequestBody PayeeAccountDetails payeeAccountDetails){
        try{
        	tMBService.addPayee(payeeAccountDetails);
            return new Status(1,"Payee Account  added");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }
    @RequestMapping(value="/fundtransferinput", method = RequestMethod.GET)
    public @ResponseBody
    List<FromAccountsList> getFromAccountsList() {
        List<FromAccountsList> fromAccountsList = null;
        try {
        	if(session!=null&&session.getAttribute("userid")!=null)
        	{
        	String userid = (String)session.getAttribute("userid");
        	fromAccountsList = tMBService.getFromAccountsList(userid);
        
        	}
        	else
        	{
        		fromAccountsList = tMBService.getFromAccountsList("elavarasan");
        	}
        	
        	} catch (Exception e) {
            e.printStackTrace();
        }
        return fromAccountsList;
    }

    @RequestMapping(value="/getifsccode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<BankDetails>  getIFSCCode(@RequestBody IFSCCodeSearch iFSCCodeSearch){
    	List<BankDetails> bankDetailsList = null;
        try {
        	
        	bankDetailsList = tMBService.getIFSCCode(iFSCCodeSearch);

        } catch (Exception e) {
            e.printStackTrace();
        }
    return bankDetailsList;
    }
    
    
 @RequestMapping(value = "/moneytransfer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    
    public @ResponseBody
    Status transferMoney(@RequestBody FundTransferInput fundTransferInput){
        try{
        	tMBService.transferMoney(fundTransferInput);
            return new Status(1,"Money transferred to the payee account");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }
    
}
