package controllers;

import java.util.List;

import controllers.Forms;

import play.*;
import play.mvc.*;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import controllers.*;
import play.mvc.Http.Request;
import play.mvc.Http.*;
import play.mvc.Http.RequestHeader;
import views.html.*;
import play.data.Form;
import models.*;
import play.api.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

public class Application extends Controller {

	static Form<Forms.newUser> userForm = Form.form(Forms.newUser.class);
	static Form<Forms.StandForm> standForm = Form.form(Forms.StandForm.class);

    /** indexへのレンダリング */
    public Result index() {
        return ok(index.render(Stand.all(),standForm));
    }

	public Result vote() {
		return redirect(routes.Application.newUser());
	}

	/** modelのStandとUserのall機能を呼ぶ出す */
    public Result newUser() {
        return ok(vote.render(userForm,Stand.all(),User.all()));
    }

	/** newUserのフォームにstandnameとnameを格納し */
	public Result addUser() {

		Form<Forms.newUser> filledForm = userForm.bindFromRequest();

		if (filledForm.hasErrors()) {

			return badRequest(vote.render(filledForm, Stand.all(), User.all()));

		} else {

   /**格納したstandnameを取り出す、modelのStandのcheckId機能を呼び出す standnameとIDを変更する */
			Long id = Stand.checkId(filledForm.get().stdn);
			/** フォームに残してるnameを取り出す */
			String name = filledForm.get().name;
			/** modelのUserのcreate機能を呼ぶ出す */
			User.create(name, id);
			return redirect(routes.Application.allUsers());
        }
	}

    public Result aboutUsers(Long id) {

    	return ok(aboutUser.render(User.selectName(id)));
    }

    public Result allUsers () {

        return ok(showUser.render(User.all(),Stand.all()));
    }

    /**変数でフォームに入力した内容を返す*/
    public Result addStand() {

	    Form<Forms.StandForm>filledForm = standForm.bindFromRequest();

	    if (filledForm.hasErrors()) {
            return badRequest(index.render(Stand.all(),filledForm));
	    }else {
	    	JsonNode getInput = Stand.create(filledForm.get());


            return ok(seclet.render(getInput));
        }
    }
}



	/*public Result ip() {

		String remote = request().remoteAddress();

		Context req = Context.current();

		//String remote_address = req.getHeader("x-forwarded-for");

	    String remoteaddress = request().remoteAddress() ;

	    String user_agent = request().getHeader("User-Agent");
        return ok(remote);
	   //return ok(ip.render(remote_address,remoteaddress,user_agent));

	/*	Request r = new Request();
		String remote = r.remoteAddress();
		return ok(ip.render(remote));
 */




