package com.example.demo.Service;

import com.example.demo.Entity.ValuteCursEntity;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlParser {

    public List<ValuteCursEntity> getValuteCursEntity() throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL("http://www.cbr.ru/scripts/XML_daily.asp").openStream());


        List<ValuteCursEntity> currencies = new ArrayList<>();
        NodeList nodeList = doc.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                Integer NumCode = Integer.parseInt(elem.getElementsByTagName("NumCode")
                        .item(0).getChildNodes().item(0).getNodeValue());

                String CharCode = elem.getElementsByTagName("CharCode").item(0)
                        .getChildNodes().item(0).getNodeValue();

                Integer Nominal = Integer.parseInt(elem.getElementsByTagName("Nominal")
                        .item(0).getChildNodes().item(0).getNodeValue());

                String Name = elem.getElementsByTagName("Name").item(0)
                        .getChildNodes().item(0).getNodeValue();

                String Value = elem.getElementsByTagName("Value").item(0)
                        .getChildNodes().item(0).getNodeValue();

                currencies.add(new ValuteCursEntity(NumCode, CharCode, Nominal, Name, Value));
            }
        }
        return currencies;
    }
}

