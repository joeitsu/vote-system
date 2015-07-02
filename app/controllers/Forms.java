package controllers;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;
import play.api.mvc.*;
import play.db.ebean.Model;


public class Forms extends Controller {

    public static class newUser {

    	public String stdn;
    	public String name;
}

    public static class StandForm {


        public String standname;
        public String post;

 }

    public static class aboutUser {

       public String std;

    }


}