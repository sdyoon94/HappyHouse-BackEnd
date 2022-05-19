package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.NewsDto;


@Service
public class NewsServiceImpl implements NewsService{

	@Override
	public List<NewsDto> getNewsList() throws Exception {
		List<NewsDto> list=new ArrayList<NewsDto>();
		String origin_url="http://www.jkapt.com/";
		String url="http://www.jkapt.com/sub.html?section=sc2&section2=";
		Document doc = Jsoup.connect(url).get();
		Elements contents=doc.select(".sub_read_list_box>dl>dt>a");
		Elements contents1=doc.select(".sub_read_list_box>p>a>img");
		Elements contents2=doc.select(".sub_read_list_box>dl>dd>a");
		for (int i = 0; i < 10; i++) {
			list.add(new NewsDto(origin_url+contents1.get(i).attr("src").substring(2), contents.get(i).text(), contents2.get(i).text(), origin_url+contents.get(i).attr("href")));
		}
		return list;
	}


}
