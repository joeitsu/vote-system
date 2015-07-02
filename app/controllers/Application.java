package controllers;

import java.util.List;

import controllers.Forms;

import play.*;
import play.mvc.*;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import controllers.*;

import views.html.*;
import play.data.Form;
import models.*;
import play.api.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

public class Application extends Controller {


    static Form<Forms.newUser> userForm = Form.form(Forms.newUser.class);
    static Form<Forms.StandForm> standForm = Form.form(Forms.StandForm.class);



    public Result vote () {
        return redirect(routes.Application.newUser());
    }

    /** indexへのレンダリング */
    public Result index() {
        return ok(index.render(standForm));
    }

    public Result newUser() {
        return ok(vote.render(User.all(),Stand.all()));
    }

    public Result addUser() {
        Form<Forms.newUser> filledForm = userForm.bindFromRequest();
        Long id = Stand.checkId(filledForm.get().stdn);
        String name = filledForm.get().name;

        User.create(name,id);

        return redirect(routes.Application.allUsers());

    }
    public Result aboutUsers(Long id) {

    	return ok(about.render(User.selectName(id)));
    }
    public Result allUsers () {

        return ok(showUser.render(User.all(),Stand.all()));
    }

    /**変数でフォームに入力した内容を返す*/
    public Result addStand() {
	    Form<Forms.StandForm>filledForm = standForm.bindFromRequest();
	    if (filledForm.hasErrors()) {
            return badRequest(index.render(filledForm));
	    }
        else {
        JsonNode getInput = Stand.create(filledForm.get());

        return ok(seclet.render(getInput));
        }
   }


}
