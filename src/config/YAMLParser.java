package config;

import java.io.Reader;
import java.io.StringReader;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.parser.ParserImpl;
import org.yaml.snakeyaml.reader.StreamReader;

public class YAMLParser {
	public static void parse(){
		Yaml yaml=new Yaml();
		for(Event event :yaml.parse(new StringReader("abc: 56\n---\n4\n---\nqwe\n"))){
		//	System.out.println(event.getStartMark());
			break;
		}
		ParserImpl p; 
		}
	public static void main1(String[] args){
		parse();
	}
	
}
