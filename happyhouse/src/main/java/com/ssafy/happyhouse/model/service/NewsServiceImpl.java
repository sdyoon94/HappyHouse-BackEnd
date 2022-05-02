package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;


@Service
public class NewsServiceImpl implements NewsService{

	@Override
	public List<String[]> NewsList() throws Exception {
		List<String[]> list=new ArrayList<String[]>();
		String origin_url="http://www.jkapt.com/";
		String url="http://www.jkapt.com/sub.html?section=sc2&section2=";
		Document doc = Jsoup.connect(url).get();
		Elements contents=doc.select(".sub_read_list_box>dl>dt>a");
		for (int i = 0; i < 8; i++) {
			list.add(new String[] {contents.get(i).text(),origin_url+contents.get(i).attr("href")});
		}
		return list;
	}


}
