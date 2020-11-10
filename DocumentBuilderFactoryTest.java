import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import java.io.IOException;

class Scratch {

    private static String xmlFileName = "D:\\WORK\\Programming\\pgu-selenium-tests\\src\\test\\resources\\testng_dav.xml";
    private static DocumentBuilder documentBuilder;
    private static Document document;
    private NodeList nodeList;
    private XPathExpression xPathExpression;

    public static void main(String[] args) {
        // Заморочное чтение параметров - не использовать
        // Создается построитель документа
        try {
            documentBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        // Создается дерево DOM документа из файла
        try {
            document = documentBuilder.parse(xmlFileName);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        // Получение списка всех элементов parameter внутри корневого элемента
        // (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList parameterElements = document.getDocumentElement()
                .getElementsByTagName("parameter");
        int chromedriverI = -1;
        int homepageI = -1;
        // Перебеор всех элементов parameter
        for (int i = 0; i < parameterElements.getLength(); i++) {
            Node parameterNode = parameterElements.item(i);
            // Получение атрибутов
            NamedNodeMap attributes = parameterNode.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                String nodeName = attributes.item(j).getNodeName();
                String nodeValue = attributes.item(j).getNodeValue();
                if (nodeName.equals("name") && nodeValue.equals("chromedriver")) {
                    chromedriverI = i; // Нашли для chromedriver
                }
                if (nodeName.equals("name") && nodeValue.equals("homepage")) {
                    homepageI = i; // Нашли для homepage
                }
            }
        }
        // Для chromedriver
        if (chromedriverI != -1) {
            Node parameterNode = parameterElements.item(chromedriverI);
            // Получение атрибутов
            NamedNodeMap attributes = parameterNode.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                String nodeName = attributes.item(j).getNodeName();
                String nodeValue = attributes.item(j).getNodeValue();
                if (nodeName.equals("value")) {
                    System.out.println("chromedriver=" + nodeValue);
                }
            }
        }
        // Для homepage
        if (homepageI != -1) {
            Node parameterNode = parameterElements.item(homepageI);
            // Получение атрибутов
            NamedNodeMap attributes = parameterNode.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                String nodeName = attributes.item(j).getNodeName();
                String nodeValue = attributes.item(j).getNodeValue();
                if (nodeName.equals("value")) {
                    System.out.println("homepage=" + nodeValue);
                }
            }
        }

    }
}