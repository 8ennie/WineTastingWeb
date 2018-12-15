package application.localisation;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ResourceBundleUtils {


    public enum ResourceKeys
    {
    	txt_login_Lable,txt_userName_Lable,txt_password_Lable,txt_register_Button,txt_login_Button
    }



    private static final String INDICATOR_MISSING_RESOURCE = "?";
    private static final String INDICATOR_MISSING_KEY = "??";

    public static String getLangString(final ResourceBundle resourceBundle,
                                       final ResourceKeys key)
    {
        if (resourceBundle != null)
        {
            try
            {
                return resourceBundle.getString(key.name());
            }
            catch (final MissingResourceException e)
            {
                return INDICATOR_MISSING_KEY + key;
            }
        }
        return INDICATOR_MISSING_RESOURCE + key;
    }

    public static void main(final String[] args) throws MissingResourceException
    {
        System.out.println("Current Locale: " + Locale.getDefault());
        final String BUNDLE_BASENAME = "Login";
        showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.GERMANY));
        showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.UK));
    }
    
    
    private static void showTexts(final ResourceBundle resourceBundle)
    
    {
    	final String txt_password_lable = ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_password_Lable);
        
        final String txt_userName_lable = ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_userName_Lable);
        
        final String txt_login_lable =ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_login_Lable);
        
        final String txt_register_Button =ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_register_Button);
        
        final String txt_login_Button =ResourceBundleUtils.getLangString(resourceBundle,
                ResourceKeys.txt_login_Button);
       
    }






}
