java -jar codegen.jar testfiles/nameanalysis/ok2.in > test.s
as test.s -o test.o
ld test.o -o test
./test
