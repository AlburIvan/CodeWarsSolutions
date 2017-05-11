package com.raworkstudio.codewars.breadcrumb_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Ivan Alburquerque on 4/20/2017.
 */
public class BreadcrumbGenerator {



    private final String URL_REGEX = "(?:http|https):\\/\\/(.*)";
    private final String DOT_MATCHER_REGEX = ".*\\..*";


    private Pattern pattern = Pattern.compile(URL_REGEX);

    private Pattern dotPattern = Pattern.compile(DOT_MATCHER_REGEX);


    public String generate_bc(String site, String separator) {

        List<String> anchorsLists = new ArrayList<>();

        System.out.println("Link: " + site);

        // http://www.mysite.com/pictures/holidays.html

        // <a href="/">HOME</a> : <a href="/pictures/">PICTURES</a> : <span class="active">HOLIDAYS</span>"


        Matcher matcher = pattern.matcher(site);


        if (matcher.find()) {
            System.out.println(matcher.group(1));


            for (String s : matcher.group(1).split("/")) {


                Matcher matcher1 = dotPattern.matcher(s);


                if (matcher1.find()) {
                    System.out.println(createTag("/", s, true));
                } else {
                    System.out.println(createTag("/", s, false));
                }



//
//
//
//
//                anchorsLists.add(createTag("/", s));
            }


        }


//        anchorsLists.stream()
//                .filter( it -> it.startsWith("s"))
//                .collect(Collectors.toList());


        return anchorsLists.stream()
                .collect(Collectors.joining(separator));
    }



    private String createTag(String href, String value, boolean isActive) {

        String completeHref;

        if (isActive) {
            completeHref = String.format(Locale.ENGLISH, "<span class=\"active\">%s</span> ", value.toUpperCase());
        }
        else {
            completeHref = String.format(Locale.ENGLISH, "<a href=\"%s\">%s</a> ", href, value.toUpperCase());
        }

        return completeHref;
    }


}
