# Makefile - lab3
# Contains all build information to make life easier.

SRC  = lib/*.java
DOCS = docs
TEST = test/util/Runner

all: clean
	javac $(SRC)

$(DOCS): .PHONY
	javadoc $(SRC) -d $(DOCS)

test: clean .PHONY
	javac $(TEST).java
	java $(TEST)

clean:
	rm -f *.class lib/*.class test/*.class test/util/*.class

.PHONY:
