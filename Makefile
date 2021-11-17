all: run

clean:
	rm -f out/Application.jar out/SubStrSearch.jar

out/Application.jar: out/parcs.jar src/Application.java src/Input.java
	@javac -cp out/parcs.jar src/Application.java src/Input.java
	@jar cf out/Application.jar -C src Application.class -C src Input.class
	@rm -f src/Application.class src/Input.class

out/SubStrSearch.jar: out/parcs.jar src/SubStrSearch.java src/Input.java
	@javac -cp out/parcs.jar src/SubStrSearch.java src/Input.java
	@jar cf out/SubStrSearch.jar -C src SubStrSearch.class -C src Input.class
	@rm -f src/SubStrSearch.class src/Input.class

build: out/Application.jar out/SubStrSearch.jar

run: out/Application.jar out/SubStrSearch.jar
	@cd out && java -cp 'parcs.jar:Application.jar' Application
