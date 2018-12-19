package application.localisation;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class StandsResourceBundleUtils {

	public enum StandsResourceKeys {
		txt_settings_Menu, txt_language_Menu, txt_german_MenuItem, txt_english_MenuItem, txt_user_Menu, txt_logOut_MenuItem, txt_standTitle_Lable, txt_back_Button, txt_search_Lable, txt_editWines_Button, txt_addStand_Button, txt_removeStand_Button, txt_search_TextField, txt_standNr_TableColumn, txt_standName_TableColumn, txt_standLocation_TableColumn, txt_standOwner_TableColumn
	}

	private static final String INDICATOR_MISSING_RESOURCE = "?";
	private static final String INDICATOR_MISSING_KEY = "??";

	public static String getLangString(final ResourceBundle resourceBundle, final StandsResourceKeys key) {
		if (resourceBundle != null) {
			try {
				return resourceBundle.getString(key.name());
			} catch (final MissingResourceException e) {
				return INDICATOR_MISSING_KEY + key;
			}
		}
		return INDICATOR_MISSING_RESOURCE + key;
	}

	public static void main(final String[] args) throws MissingResourceException {
		System.out.println("Current Locale: " + Locale.getDefault());
		final String BUNDLE_BASENAME = "Stands";
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.GERMANY));
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.UK));
	}

	private static void showTexts(final ResourceBundle resourceBundle) {

		final String txt_settings_Menu = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_settings_Menu);
		final String txt_language_Menu = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_language_Menu);
		final String txt_german_MenuItem = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_german_MenuItem);
		final String txt_english_MenuItem = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_english_MenuItem);
		final String txt_user_Menu = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_user_Menu);
		final String txt_logOut_MenuItem = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_logOut_MenuItem);
		final String txt_standTitle_Lable = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_standTitle_Lable);
		final String txt_back_Button = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_back_Button);
		final String txt_search_Lable = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_search_Lable);
		final String txt_editWines_Button = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_editWines_Button);
		final String txt_addStand_Button = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_addStand_Button);
		final String txt_removeStand_Button = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_removeStand_Button);
		final String txt_search_TextField = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_search_TextField);
		final String txt_standNr_TableColumn = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_standNr_TableColumn);
		final String txt_standName_TableColumn = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_standName_TableColumn);
		final String txt_standLocation_TableColumn = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_standLocation_TableColumn);
		final String txt_standOwner_TableColumn = StandsResourceBundleUtils.getLangString(resourceBundle,
				StandsResourceKeys.txt_standOwner_TableColumn);

	}

}
