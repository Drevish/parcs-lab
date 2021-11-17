all: run

clean:
	rm -f out/Application.jar out/SubStrSearch.jar

out/Application.jar: out/parcs.jar src/Application.java src/Node.java
	@javac -cp out/parcs.jar src/Application.java src/Node.java
	@jar cf out/Application.jar -C src Application.class -C src Node.class
	@rm -f src/Application.class src/Node.class

out/SubStrSearch.jar: out/parcs.jar src/SubStrSearch.java src/Node.java
	@javac -cp out/parcs.jar src/SubStrSearch.java src/Node.java
	@jar cf out/SubStrSearch.jar -C src SubStrSearch.class -C src Node.class
	@rm -f src/SubStrSearch.class src/Node.class

build: out/Application.jar out/SubStrSearch.jar

run: out/Application.jar out/SubStrSearch.jar
	@cd out && java -cp 'parcs.jar:Application.jar' Application
