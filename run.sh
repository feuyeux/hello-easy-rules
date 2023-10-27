export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-8.jdk/Contents/Home
mvn clean compile exec:java -Dexec.mainClass="org.feuyeux.workflow.HelloEasyRules" -Dexec.args="Hello EasyFlows"