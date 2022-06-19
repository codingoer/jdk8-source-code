package com.sun.tools.internal.ws.wsdl.document.soap;

import javax.xml.namespace.QName;

public interface SOAP12Constants {
   String NS_WSDL_SOAP = "http://schemas.xmlsoap.org/wsdl/soap12/";
   String NS_SOAP_ENCODING = "http://schemas.xmlsoap.org/soap/encoding/";
   String URI_SOAP_TRANSPORT_HTTP = "http://www.w3.org/2003/05/soap/bindings/HTTP/";
   QName QNAME_ADDRESS = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "address");
   QName QNAME_BINDING = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "binding");
   QName QNAME_BODY = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "body");
   QName QNAME_FAULT = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "fault");
   QName QNAME_HEADER = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "header");
   QName QNAME_HEADERFAULT = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "headerfault");
   QName QNAME_OPERATION = new QName("http://schemas.xmlsoap.org/wsdl/soap12/", "operation");
   QName QNAME_TYPE_ARRAY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "Array");
   QName QNAME_ATTR_GROUP_COMMON_ATTRIBUTES = new QName("http://schemas.xmlsoap.org/soap/encoding/", "commonAttributes");
   QName QNAME_ATTR_ARRAY_TYPE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "arrayType");
   QName QNAME_ATTR_ITEM_TYPE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "itemType");
   QName QNAME_ATTR_ARRAY_SIZE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "arraySize");
   QName QNAME_ATTR_OFFSET = new QName("http://schemas.xmlsoap.org/soap/encoding/", "offset");
   QName QNAME_ATTR_POSITION = new QName("http://schemas.xmlsoap.org/soap/encoding/", "position");
   QName QNAME_TYPE_BASE64 = new QName("http://schemas.xmlsoap.org/soap/encoding/", "base64");
   QName QNAME_ELEMENT_STRING = new QName("http://schemas.xmlsoap.org/soap/encoding/", "string");
   QName QNAME_ELEMENT_NORMALIZED_STRING = new QName("http://schemas.xmlsoap.org/soap/encoding/", "normalizedString");
   QName QNAME_ELEMENT_TOKEN = new QName("http://schemas.xmlsoap.org/soap/encoding/", "token");
   QName QNAME_ELEMENT_BYTE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "byte");
   QName QNAME_ELEMENT_UNSIGNED_BYTE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedByte");
   QName QNAME_ELEMENT_BASE64_BINARY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "base64Binary");
   QName QNAME_ELEMENT_HEX_BINARY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "hexBinary");
   QName QNAME_ELEMENT_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "integer");
   QName QNAME_ELEMENT_POSITIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "positiveInteger");
   QName QNAME_ELEMENT_NEGATIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "negativeInteger");
   QName QNAME_ELEMENT_NON_NEGATIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "nonNegativeInteger");
   QName QNAME_ELEMENT_NON_POSITIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "nonPositiveInteger");
   QName QNAME_ELEMENT_INT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "int");
   QName QNAME_ELEMENT_UNSIGNED_INT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedInt");
   QName QNAME_ELEMENT_LONG = new QName("http://schemas.xmlsoap.org/soap/encoding/", "long");
   QName QNAME_ELEMENT_UNSIGNED_LONG = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedLong");
   QName QNAME_ELEMENT_SHORT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "short");
   QName QNAME_ELEMENT_UNSIGNED_SHORT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedShort");
   QName QNAME_ELEMENT_DECIMAL = new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal");
   QName QNAME_ELEMENT_FLOAT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "float");
   QName QNAME_ELEMENT_DOUBLE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "double");
   QName QNAME_ELEMENT_BOOLEAN = new QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean");
   QName QNAME_ELEMENT_TIME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "time");
   QName QNAME_ELEMENT_DATE_TIME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "dateTime");
   QName QNAME_ELEMENT_DURATION = new QName("http://schemas.xmlsoap.org/soap/encoding/", "duration");
   QName QNAME_ELEMENT_DATE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "date");
   QName QNAME_ELEMENT_G_MONTH = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gMonth");
   QName QNAME_ELEMENT_G_YEAR = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gYear");
   QName QNAME_ELEMENT_G_YEAR_MONTH = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gYearMonth");
   QName QNAME_ELEMENT_G_DAY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gDay");
   QName QNAME_ELEMENT_G_MONTH_DAY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gMonthDay");
   QName QNAME_ELEMENT_NAME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "Name");
   QName QNAME_ELEMENT_QNAME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "QName");
   QName QNAME_ELEMENT_NCNAME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NCName");
   QName QNAME_ELEMENT_ANY_URI = new QName("http://schemas.xmlsoap.org/soap/encoding/", "anyURI");
   QName QNAME_ELEMENT_ID = new QName("http://schemas.xmlsoap.org/soap/encoding/", "ID");
   QName QNAME_ELEMENT_IDREF = new QName("http://schemas.xmlsoap.org/soap/encoding/", "IDREF");
   QName QNAME_ELEMENT_IDREFS = new QName("http://schemas.xmlsoap.org/soap/encoding/", "IDREFS");
   QName QNAME_ELEMENT_ENTITY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "ENTITY");
   QName QNAME_ELEMENT_ENTITIES = new QName("http://schemas.xmlsoap.org/soap/encoding/", "ENTITIES");
   QName QNAME_ELEMENT_NOTATION = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NOTATION");
   QName QNAME_ELEMENT_NMTOKEN = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NMTOKEN");
   QName QNAME_ELEMENT_NMTOKENS = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NMTOKENS");
   QName QNAME_TYPE_STRING = new QName("http://schemas.xmlsoap.org/soap/encoding/", "string");
   QName QNAME_TYPE_NORMALIZED_STRING = new QName("http://schemas.xmlsoap.org/soap/encoding/", "normalizedString");
   QName QNAME_TYPE_TOKEN = new QName("http://schemas.xmlsoap.org/soap/encoding/", "token");
   QName QNAME_TYPE_BYTE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "byte");
   QName QNAME_TYPE_UNSIGNED_BYTE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedByte");
   QName QNAME_TYPE_BASE64_BINARY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "base64Binary");
   QName QNAME_TYPE_HEX_BINARY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "hexBinary");
   QName QNAME_TYPE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "integer");
   QName QNAME_TYPE_POSITIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "positiveInteger");
   QName QNAME_TYPE_NEGATIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "negativeInteger");
   QName QNAME_TYPE_NON_NEGATIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "nonNegativeInteger");
   QName QNAME_TYPE_NON_POSITIVE_INTEGER = new QName("http://schemas.xmlsoap.org/soap/encoding/", "nonPositiveInteger");
   QName QNAME_TYPE_INT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "int");
   QName QNAME_TYPE_UNSIGNED_INT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedInt");
   QName QNAME_TYPE_LONG = new QName("http://schemas.xmlsoap.org/soap/encoding/", "long");
   QName QNAME_TYPE_UNSIGNED_LONG = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedLong");
   QName QNAME_TYPE_SHORT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "short");
   QName QNAME_TYPE_UNSIGNED_SHORT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedShort");
   QName QNAME_TYPE_DECIMAL = new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal");
   QName QNAME_TYPE_FLOAT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "float");
   QName QNAME_TYPE_DOUBLE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "double");
   QName QNAME_TYPE_BOOLEAN = new QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean");
   QName QNAME_TYPE_TIME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "time");
   QName QNAME_TYPE_DATE_TIME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "dateTime");
   QName QNAME_TYPE_DURATION = new QName("http://schemas.xmlsoap.org/soap/encoding/", "duration");
   QName QNAME_TYPE_DATE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "date");
   QName QNAME_TYPE_G_MONTH = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gMonth");
   QName QNAME_TYPE_G_YEAR = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gYear");
   QName QNAME_TYPE_G_YEAR_MONTH = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gYearMonth");
   QName QNAME_TYPE_G_DAY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gDay");
   QName QNAME_TYPE_G_MONTH_DAY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "gMonthDay");
   QName QNAME_TYPE_NAME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "Name");
   QName QNAME_TYPE_QNAME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "QName");
   QName QNAME_TYPE_NCNAME = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NCName");
   QName QNAME_TYPE_ANY_URI = new QName("http://schemas.xmlsoap.org/soap/encoding/", "anyURI");
   QName QNAME_TYPE_ID = new QName("http://schemas.xmlsoap.org/soap/encoding/", "ID");
   QName QNAME_TYPE_IDREF = new QName("http://schemas.xmlsoap.org/soap/encoding/", "IDREF");
   QName QNAME_TYPE_IDREFS = new QName("http://schemas.xmlsoap.org/soap/encoding/", "IDREFS");
   QName QNAME_TYPE_ENTITY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "ENTITY");
   QName QNAME_TYPE_ENTITIES = new QName("http://schemas.xmlsoap.org/soap/encoding/", "ENTITIES");
   QName QNAME_TYPE_NOTATION = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NOTATION");
   QName QNAME_TYPE_NMTOKEN = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NMTOKEN");
   QName QNAME_TYPE_NMTOKENS = new QName("http://schemas.xmlsoap.org/soap/encoding/", "NMTOKENS");
   QName QNAME_TYPE_LANGUAGE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "LANGUAGE");
   QName QNAME_ATTR_ID = new QName("", "id");
   QName QNAME_ATTR_HREF = new QName("", "ref");
}
