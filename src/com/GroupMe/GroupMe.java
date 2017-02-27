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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GroupMe {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException,
			InterruptedException {

		String bot_id = "5527134bd7255e61231a2efef7";

		String token = "a63fa210dc570134811155b8f293a4e8";

		String messageId = "";

		Bot bot = new Bot(bot_id);

		while (true) {

			String REQUEST_URL = "https://api.groupme.com/v3/groups/29230763/messages";

			String urlParameters = "?token=" + token + "&after_id="
					+ messageId.replace("\"", "") + "&limit=10";

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
					System.out.println(messageId);
					tmp = jsonArray.get(i).getAsJsonObject().get("text")
							.toString();
					System.out.println(tmp);
					if (jsonArray.get(i).getAsJsonObject().get("sender_type").toString().replaceAll("\"", "").equals("user")) {
						if (tmp.toLowerCase().contains("thai")) {
							bot.sendTextMessage("Thai is hella weak.");
						}
						if (tmp.toLowerCase().contains("hao")) {
							bot.sendTextMessage("Hao is hella weak.");
						}
						if (tmp.toLowerCase().contains("beepboop")) {
							bot.sendTextMessage("BeepBoop bot is the best. THE BEST. THE BEST.");
						}
					}
				}

				System.out.println(messageId);
				System.out.println("Exiting");
				connection.disconnect();
			}
			Thread.sleep(5000);
		}

	}

}
