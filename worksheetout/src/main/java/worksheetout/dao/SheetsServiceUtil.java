package worksheetout.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

/**
 * The class for creating a connection to Google Sheets
 */

public class SheetsServiceUtil {

    private static final String APPLICATION_NAME = "Google Sheets Example";
    
    /**
     * Creating a connection to Google Sheets
     * @return Sheets object that allows communication with Google Sheets
     * @throws IOException
     * @throws GeneralSecurityException 
     */
    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = GoogleAuthorizeUtil.authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }

}