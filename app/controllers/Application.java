package controllers;

import java.util.List;
import akka.actor.dsl.Inbox.Get;
import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import controllers.*;
import views.html.*;
import play.api.mvc.*;

public class Application extends Controller {

	static Form<Forms.newUser> userForm = Form.form(Forms.newUser.class);

    public Result index() {

    return redirect(routes.Application.newUser());

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
