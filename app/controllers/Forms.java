package controllers;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;
import play.api.mvc.*;


public class Forms extends Controller {

    public static class newUser {

    	public String stdn;
    	public String name;

    }

    public static class StandForm{

        public String standname;
        public String post;

        public String validate(){
          	if(Stand.checkName(standname)!=null||standname.length()==0){
          		return "立候補、また役職名が有効ではありません。";
          	}
          	return null;
        }
    }


}
