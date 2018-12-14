/**
 * 
 */
package application.model.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import application.exceptions.CsvHandlerException;

/**
 * @author Noah Ruben
 * @created 27.03.2018
 *
 */
public class CsvHandler{
//	public static final Logger LOGGER = Logger.getLogger(CsvHandler.class);

	public static final char sep1 = ';';

	public static final char sep2 = ',';

	private final String DATEI_ENDUNG = ".csv";

	private final DateTimeFormatter dateTimeFormatterForFileCreation = DateTimeFormatter.ofPattern("dd_MM_yyhh_mm_ss");
	private final DateTimeFormatter dateTimeFormatterForFileWriting = DateTimeFormatter.ofPattern("dd.MM.yy  hh:mm:ss");

	private final boolean APPEND;

	private final File THE_FILE;

	private BufferedWriter bufferedWriter;

	private BufferedReader bufferedReader;

	public CsvHandler(File theFile, boolean appendToFile) throws CsvHandlerException{
		this.THE_FILE = theFile;

		this.APPEND = appendToFile;

		try{
			this.bufferedWriter = new BufferedWriter(new FileWriter(this.THE_FILE, this.APPEND));

			this.bufferedReader = new BufferedReader(new FileReader(this.THE_FILE));
		} catch (Exception exception){
//			LOGGER.error(exception);
			throw new CsvHandlerException("Could not create a CsvHandler");
		}
	}

	/**
	 * @param tHE_DIR
	 * @param tHE_FILE_NAME
	 * @param aPPEND
	 * @param tHE_FILE
	 */
	public CsvHandler(File theDir, String theFileName, boolean appendToFile) throws CsvHandlerException{
		final File THE_DIR = theDir;
		final String THE_FILE_NAME = "/" + theFileName;

		this.APPEND = appendToFile;

		if(!THE_DIR.exists())
			THE_DIR.mkdirs();

		try{
			this.THE_FILE = new File(THE_DIR.getAbsolutePath() + THE_FILE_NAME + this.DATEI_ENDUNG);
//			LOGGER.debug(this.THE_FILE.getAbsolutePath());

			this.bufferedWriter = new BufferedWriter(new FileWriter(this.THE_FILE, this.APPEND));

			this.bufferedReader = new BufferedReader(new FileReader(this.THE_FILE));

		} catch (Exception exception){
//			LOGGER.error("", exception);
			throw new CsvHandlerException("Could not create a CsvHandler");
		}
	}

	/**
	 * @return the dATEI_ENDUNG
	 */
	public String getDATEI_ENDUNG(){
		return this.DATEI_ENDUNG;
	}

	/**
	 * @return the dateTimeFormatterFileCreation
	 */
	public DateTimeFormatter getDateTimeFormatterFileCreation(){
		return this.dateTimeFormatterForFileCreation;
	}

	/**
	 * @return the dateTimeFormatterForFileWriting
	 */
	public DateTimeFormatter getDateTimeFormatterForFileWriting(){
		return this.dateTimeFormatterForFileWriting;
	}

	/**
	 * @return the tHE_FILE
	 */
	public File getTHE_FILE(){
		return this.THE_FILE;
	}

	/**
	 * @return the aPPEND
	 */
	public boolean isAPPEND(){
		return this.APPEND;
	}

	public List<List<String>> readCompleteFile(){

		List<List<String>> listOfLinesAsList = new ArrayList<List<String>>();
		List<String> lineAsList;

		try{
			this.reNewBufferedReader();
			while ((lineAsList = this.readLineToList(false)).isEmpty() == false){
				listOfLinesAsList.add(lineAsList);
			}
		} catch (Exception e){
//			LOGGER.error(e, e);
		}

		return listOfLinesAsList;
	}

	public List<String> readLineToList(boolean reset){
		String line = this.readLineToString(reset);

		String[] lineAsArray;
		try{
			lineAsArray = line.split(String.valueOf(sep1));
		} catch (Exception e){
			return Collections.emptyList();
		}

		return Arrays.asList(lineAsArray);
	}

	public String readLineToString(boolean reset){
		String line;
		try{
			line = this.bufferedReader.readLine();

			if(reset){
				this.reNewBufferedReader();
			}
		} catch (Exception exception){
//			LOGGER.error(exception);
			line = null;
		}

		return line;
	}

	public void write(List<String> list){
		StringBuilder stringBuilder = new StringBuilder();

		for(String string : list){
			stringBuilder.append(string);
			stringBuilder.append(sep1);
		}

		try{
			this.bufferedWriter.write(stringBuilder.toString());
			this.bufferedWriter.newLine();
			this.bufferedWriter.flush();

		} catch (IOException ioException){
//			LOGGER.error("Could not write in file", ioException);
		}
	}

	public void write(String string){
		try{
			this.bufferedWriter.write(string);
			this.bufferedWriter.newLine();
			this.bufferedWriter.flush();

		} catch (IOException ioException){
//			LOGGER.error("Could not write in file", ioException);
		}
	}

	/**
	 * @throws IOException
	 */
	private void reNewBufferedReader() throws IOException{
		this.bufferedReader.close();

		this.bufferedReader = new BufferedReader(new FileReader(this.THE_FILE));
	}
}
