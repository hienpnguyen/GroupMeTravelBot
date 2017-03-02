package com.GroupMe;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GroupMe {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException,
			InterruptedException, UnsupportedOperationException {
		
		LinkedList<String> list = new LinkedList<String>();

		String bot_id = "";

		String token = "";

		String messageId = "";

		Bot bot = new Bot(bot_id);
		
		

		/*while (true) {

			//String REQUEST_URL = "https://api.groupme.com/v3/groups/29230763/messages"; //Bot Chat
			String REQUEST_URL = "https://api.groupme.com/v3/groups/27273483/messages";
			String REQUEST_CAT_JOKE = "http://catfacts-api.appspot.com/api/facts"; //Delete later
			String REQUEST_CHUCK_JOKE = "http://api.icndb.com/jokes/random";

			String urlParameters = "?token=" + token + "&after_id="
					+ messageId.replace("\"", "") + "&limit=1";

			REQUEST_URL = REQUEST_URL + urlParameters;

			System.out.println(REQUEST_URL);

			URL url = new URL(REQUEST_URL);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);

			InputStream rd = connection.getInputStream();

			BufferedReader lines = new BufferedReader(new InputStreamReader(rd));
			
			String line = lines.readLine();
			System.out.println(line);
			if (line != null) {

				JsonElement je = new JsonParser().parse(line);

				JsonObject jo = je.getAsJsonObject();

				JsonElement response = jo.get("response");

				JsonElement message = response.getAsJsonObject()
						.get("messages");

				JsonArray jsonArray = message.getAsJsonArray();

				String tmp;
				for (int i = 0; i < jsonArray.size(); i++) {
					messageId = jsonArray.get(i).getAsJsonObject().get("id")
							.toString();
					tmp = jsonArray.get(i).getAsJsonObject().get("text")
							.toString().replace("\"", "");
					System.out.println(tmp);
					if (jsonArray.get(i).getAsJsonObject().get("sender_type").toString().replaceAll("\"", "").equals("user")) {
						if (tmp.startsWith("BeepBoop Add: ")) {
							list.add(tmp.replace("BeepBoop Add: ", ""));
						}
						if (tmp.startsWith("BeepBoop Delete: ")) {
							list.remove(Integer.parseInt(tmp.replace("BeepBoop Delete: ", "").trim())-1);
							}
						if (tmp.startsWith("BeepBoop Show")) {
							for(int j = 0; j < list.size(); j++){
								int a = j;
								System.out.println("Data At: "+list.get(j));
							bot.sendTextMessage(++a+". " +list.get(j));
							}
						}
						if(tmp.toLowerCase().contains("beepboop tell me a cat fact")){
							URL url2 = new URL(REQUEST_CAT_JOKE);
							HttpURLConnection catnection = (HttpURLConnection) url2
									.openConnection();
							catnection.setDoOutput(true);
							catnection.setDoInput(true);
							catnection.setInstanceFollowRedirects(false);
							catnection.setRequestMethod("GET");
							catnection.setUseCaches(false);

							InputStream rd2 = catnection.getInputStream();

							BufferedReader lines2 = new BufferedReader(new InputStreamReader(rd2));
							
							String line2 = lines2.readLine();
							
							System.out.println("Line2: "+line2);
							
							JsonElement je2 = new JsonParser().parse(line2);
							
							JsonObject jo2 = je2.getAsJsonObject();
							
							JsonArray jsonArray2 = jo2.get("facts").getAsJsonArray();
							String a = jsonArray2.get(0).getAsString();
							System.out.println(a);

							bot.sendTextMessage(a);
						}
						if(tmp.toLowerCase().contains("beepboop tell me a chuck norris fact")){
							URL url3 = new URL(REQUEST_CHUCK_JOKE);
							HttpURLConnection chucknection = (HttpURLConnection) url3
									.openConnection();
							chucknection.setDoOutput(true);
							chucknection.setDoInput(true);
							chucknection.setInstanceFollowRedirects(false);
							chucknection.setRequestMethod("GET");
							chucknection.setUseCaches(false);

							InputStream rd3 = chucknection.getInputStream();

							BufferedReader lines3 = new BufferedReader(new InputStreamReader(rd3));
							
							String line3 = lines3.readLine();
							
							System.out.println("Line3: "+line3);
							
							JsonElement je3 = new JsonParser().parse(line3);
							
							JsonObject jo3 = je3.getAsJsonObject();
							
							JsonObject value = jo3.get("value").getAsJsonObject();
							String a = value.get("joke").getAsString();
							System.out.println(a);

							bot.sendTextMessage(a);
						}
					}
				}

				System.out.println("Exiting");
				connection.disconnect();
			}
			Thread.sleep(1000);
		}*/

	}

}
