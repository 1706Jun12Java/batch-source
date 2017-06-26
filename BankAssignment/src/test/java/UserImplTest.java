import java.util.List;

import org.junit.Test;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.dao.UserImpl;
import com.revature.domain.User;

public class UserImplTest {

	public UserImplTest() {
		
		
	}
	@Test
	public void successfullyMakeAUSser(){
		boolean successful = false;
		try {
			successful = new UserImpl().createUser("Dylan","meep");
		} catch (InvalidUsernameException | InvalidPasswordException e) {
			e.printStackTrace();
		}
		assert(successful == false);
	}
	
	@Test
	public void userNameToLong(){
		boolean successful = false;
		try {
			new UserImpl().createUser("jfjsapojfpaofnaapfspogajgasfpojamfposjagsagjaspgag","meep");
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch( InvalidPasswordException e){
			
		}
		assert(successful==true);
	}
	public void usernameTooShort(){
		boolean successful = false;
		try {
			new UserImpl().createUser("","fmopfojsgp");
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {
			
		}
		
		assert(successful==true);
	}
	
	@Test
	public void passwordTooLong(){
		boolean successful = false;
		try {
			new UserImpl().createUser("SPongebob","fjopfnaoisagqipgsangpajsglskfplkasgpnsalmpsalmlasmpgsjaagapjgmsa");
		} catch (InvalidUsernameException e) {
			
		} catch( InvalidPasswordException e){
			successful = true;
		}
		assert(successful==true);
	}
	
	@Test
	public void usernameExists(){
		boolean successful = false;
		try {
			new UserImpl().createUser("John","fajfojamfg");
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch( InvalidPasswordException e){

		}
		assert(successful==true);
	}
	
	@Test
	public void successfullyDeleteUser(){
		boolean successful = false;
		try {
			successful = new UserImpl().deleteUser("Dylan");
		} catch (InvalidUsernameException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void noUserToDelete(){
		boolean successful = false;
		try {
			new UserImpl().deleteUser("Dylan");
		} catch (InvalidUsernameException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void usernameTooLongToDelete(){
		boolean successful = false;
		try {
			new UserImpl().deleteUser("ogjspdgojsdpogjspdolsdopgspogpslgpsld,gpdslmgpsolgmdlgmsldkgsogk");
		} catch (InvalidUsernameException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void usernameTooShortToDelete(){
		boolean successful = false;
		try {
			new UserImpl().deleteUser("");
		} catch (InvalidUsernameException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void tryingToDeleteOGSuperUser(){
		boolean successful = false;
		try {
			new UserImpl().deleteUser("Johncena");
		} catch (InvalidUsernameException e) {
			successful = true;
		}
		assert(successful==false);
	}
	
	@Test
	public void successfullyUpdateUser(){
		boolean successful = false;
		try {
			successful = new UserImpl().updateUser("John","Juan","merp",0);
		} catch (InvalidUsernameException e) {
			
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void noUserToUpdate(){
		boolean successful = false;
		try {
			  new UserImpl().updateUser("Jesus","Juan","merp",0);
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void usernameTooLongToUpdate(){
		boolean successful = false;
		try {
			  new UserImpl().updateUser("fmpoasmfpaosfpagmpoaspalfsagasgagsgasfdgpsffkgks","Juan","merp",0);
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void newUsernameTooLongToUpdate(){
		boolean successful = false;
		try {
			  new UserImpl().updateUser("Juan","sfpasfopasgpokd,gpsdopfhkfopdhjfdpgokfdsogmsdpomhfjhegmeofmg","merp",0);
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void passwordTooLongToUpdate(){
		boolean successful = false;
		try {
			  new UserImpl().updateUser("Juan","Juan","pdskgpkewpoksdopmsadmpgkpokw,foepmfdsiflkdsjmvodmvopmfdngsdaf",0);
		} catch (InvalidUsernameException e) {
			
		} catch (InvalidPasswordException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void userNameTooShortToUpdate(){
		boolean successful = false;
		try {
			  new UserImpl().updateUser("","Juan","meep",0);
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	@Test
	public void passwordTooShortToUpdate(){
		boolean successful = false;
		try {
			  new UserImpl().updateUser("Juan","Juan","",0);
		} catch (InvalidUsernameException e) {
			
		} catch (InvalidPasswordException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void newNameTooShortToUpdate(){
		boolean successful = false;
		try {
			  new UserImpl().updateUser("Juan","","fkasofqq",0);
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test 
	public void getAllUsers(){
		boolean successful = false;
		try {
			 List<User> users = new UserImpl().getAllUsers();
			 if(!users.isEmpty()){
				 successful = true;
			 }
		} catch (InvalidAccountException e) {
			
		}
		
		assert(successful==true);
	}
	
	@Test
	public void getAllUsersWIthEmptyTable(){
		boolean successful = false;
		try {
			 List<User> users = new UserImpl().getAllUsers();
			 if(!users.isEmpty()){
				 
			 }
		} catch (InvalidAccountException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void successfulLogin(){
		boolean successful = false;
		try {
			 User user = new UserImpl().logIn("Bob","marley");
			 if(user != null){
				 successful = true;
			 }
		} catch (InvalidUsernameException e) {

		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	@Test
	public void failedlLogin(){
		boolean successful = false;
		try {
			 User user = new UserImpl().logIn("Bob","foapsjf;akgg");
			 if(user != null){
				 successful = true;
			 }
		} catch (InvalidUsernameException e) {

		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void loginNameTooLong(){
		boolean successful = false;
		try {
			 User user = new UserImpl().logIn("fsld;mgpjgpeojgpmd;lsmg;lsdgms;ldgjs;geo;wjgsdkgnklsdngoinoqe","marley");
			 if(user != null){
				 
			 }
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void loginNameTooShort(){
		boolean successful = false;
		try {
			 User user = new UserImpl().logIn("","marley");
			 if(user != null){
				 
			 }
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {

		}
		
		assert(successful==true);
	}
	
	@Test
	public void loginPasswordTooShort(){
		boolean successful = false;
		try {
			 User user = new UserImpl().logIn("Bob","");
			 if(user != null){
				 
			 }
		} catch (InvalidUsernameException e) {
			
		} catch (InvalidPasswordException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void loginPasswordTooLong(){
		boolean successful = false;
		try {
			 User user = new UserImpl().logIn("Bob","gpqemgpoedpoksdpogjoiroigknsjdnfiuwebiugbsdjkfnejiwbgijdsngw");
			 if(user != null){
				 
			 }
		} catch (InvalidUsernameException e) {
			
		} catch (InvalidPasswordException e) {
			successful = true;
		}
		
		assert(successful==true);
	}
	
	@Test
	public void loginUserDoesNotExist(){
		boolean successful = false;
		try {
			 User user = new UserImpl().logIn("Paul","fmwofjs");
			 if(user != null){
				 
			 }
		} catch (InvalidUsernameException e) {
			successful = true;
		} catch (InvalidPasswordException e) {
		
		}
		
		assert(successful==true);
	}
	
	
	//Make SQL Exception test For updating a "Juan" to "JOHNCENA"
	
}
