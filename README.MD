default suite:
mvn clean test

specific suite .xml:
mvn test -DsuiteFile="path/to/xml/file"


google Search :
mvn test -DsuiteFile="src/test/resources/testNGxml/googleSearchTest.xml"