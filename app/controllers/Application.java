package controllers;

import java.util.List;

import controllers.Forms;

import play.*;
import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import controllers.*;
import views.html.*;

import play.data.Form;
import models.*;

import play.libs.Json;

import play.api.mvc.*;

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

    public Result addStand() {
	    Form<Forms.StandForm>filledForm = standForm.bindFromRequest();
	    /**変数でフォームに入力した内容を返す*/
        JsonNode getInput = Stand.create(filledForm.get());

        return ok(seclet.render(getInput));
    }

    public Result newUser() {
        return ok(index.render(userForm));
    }

    public Result addUser() {
        Form<Forms.newUser> filledForm = userForm.bindFromRequest();
        User.create(filledForm.get());

        return redirect(routes.Application.allUsers());
    }

    public Result allUsers() {
        return ok(showUser.render(User.all()));
    }
}
