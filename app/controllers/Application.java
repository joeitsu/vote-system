package controllers;

import java.util.List;
import controllers.Forms;

import controllers.routes;
import play.*;
import play.mvc.*;
import views.html.*;

import play.data.Form;
import models.*;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;

public class Application extends Controller {

    static Form<Forms.StandForm> standForm = Form.form(Forms.StandForm.class);
    /** indexへのレンダリング */
    public Result index() {
        return ok(index.render(Stand.all(),standForm));
    }

    public Result addStand() {
	    Form<Forms.StandForm>filledForm = standForm.bindFromRequest();
	    /**変数でフォームに入力した内容を返す*/
        JsonNode getInput = Stand.create(filledForm.get());

        return ok(seclet.render(getInput));
    }
}
