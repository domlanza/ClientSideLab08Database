package model.Recipe_other;

import model.webUser.*;
import dbUtils.FormatUtils;
import java.sql.ResultSet;


/* The purpose of this class is just to "bundle together" all the 
 * character data that the user might type in when they want to 
 * add a new Customer or edit an existing customer.  This String
 * data is "pre-validated" data, meaning they might have typed 
 * in a character string where a number was expected.
 * 
 * There are no getter or setter methods since we are not trying to
 * protect this data in any way.  We want to let the JSP page have
 * free access to put data in or take it out. */
public class StringData { 

    public String recipe_id = "";
    public String recipe_name = "";
    public String errorMsg = "";

    // default constructor leaves all data members with empty string (Nothing null).
    public StringData() {
    }

    // overloaded constructor sets all data members by extracting from resultSet.
    public StringData(ResultSet results) {
        try {
            // plainInteger returns integer converted to string with no commas.
            this.recipe_id = FormatUtils.plainInteger(results.getObject("recipe_id"));
            this.recipe_name = FormatUtils.formatString(results.getObject("recipe_name"));
        } catch (Exception e) {
            this.errorMsg = "Exception thrown in model.webUser.StringData (the constructor that takes a ResultSet): " + e.getMessage();
        }
    }

    public int getCharacterCount() {
        String s = this.recipe_id + this.recipe_name; 
        return s.length();
    }

    public String toString() {
        return "Recipe Id:" + this.recipe_id
                + ", Recipe Name: " + this.recipe_name;
              
    }
}
