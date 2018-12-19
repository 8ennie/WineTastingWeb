package application.localisation;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SearchResourceBundleUtils {

	public enum SearchResourceKeys {
		txt_settings_Menu,
		txt_language_Menu,
		txt_german_MenuItem,
		txt_english_MenuItem,
		txt_user_Menu,
		txt_logOut_MenuItem,
		txt_searchTitle_Lable,
		txt_back_Button,
		txt_standNr_TableColumn,
		txt_standName_TableColumn,
		txt_standLocation_TableColumn,
		txt_standOwner_TableColumn,
		txt_wineName_TableColumn,
		txt_search_Lable,
		txt_search_TextField,
		txt_chooseStand_Button,
		txt_editStand_Button
	}

	private static final String INDICATOR_MISSING_RESOURCE = "?";
	private static final String INDICATOR_MISSING_KEY = "??";

	public static String getLangString(final ResourceBundle resourceBundle, final SearchResourceKeys key) {
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
		final String BUNDLE_BASENAME = "Search";
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.GERMANY));
		showTexts(PropertyResourceBundle.getBundle(BUNDLE_BASENAME, Locale.UK));
	}

	private static void showTexts(final ResourceBundle resourceBundle) {
		
		final String txt_settings_Menu = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_settings_Menu);

		final String txt_language_Menu = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_language_Menu);

		final String txt_german_MenuItem = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_german_MenuItem);

		final String txt_english_MenuItem = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_english_MenuItem);

		final String txt_user_Menu = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_user_Menu);

		final String txt_logOut_MenuItem = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_logOut_MenuItem);
		
		final String txt_searchTitle_Lable = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_searchTitle_Lable);
		
		final String txt_back_Button = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_back_Button);
		
		final String txt_standNr_TableColumn = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_standNr_TableColumn);
		
		final String txt_standName_TableColumn = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_standName_TableColumn);
		
		final String txt_standLocation_TableColumn = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_standLocation_TableColumn);
		
		final String txt_standOwner_TableColumn = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_standOwner_TableColumn);
		
		final String txt_wineName_TableColumn = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_wineName_TableColumn);
		
		final String txt_search_Lable = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_search_Lable);
		
		final String txt_search_TextField = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_search_TextField);
		
		final String txt_chooseStand_Button = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_chooseStand_Button);
		
		final String txt_editStand_Button = SearchResourceBundleUtils.getLangString(resourceBundle,
				SearchResourceKeys.txt_editStand_Button);
		
	}

}
