# Makefile - lab3
# Contains all build information to make life easier.

SRC  = lib/*.java
DOCS = docs
TEST = test/Runner

all:
	javac $(SRC)

$(DOCS): .PHONY
	javadoc $(SRC) -d $(DOCS)

test: .PHONY
	javac test/*.java
	java $(TEST)

clean:
	rm -f *.class lib/*.class test/*.class

.PHONY: