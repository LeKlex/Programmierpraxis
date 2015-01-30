set PROG = Main

javac *.java
echo compare > diff.txt
echo OFF
set COUNT=1
:Loop
  IF %COUNT% LSS 10 (
    set IDX = "0"%COUNT%
  ) ELSE (
    set IDX = "%COUNT%"
  )
  
echo "###%IDX%###"
java -Duser.language=en -Duser.country=US %PROG% < spec.i0%IDX% > erg.out%IDX%
fc /L spec.o0%IDX% erg.out%IDX% >> diff.txt

set /a COUNT=%COUNT%+1
if %COUNT% == 13 GOTO End
GOTO Loop

:End

rem jar Mcvf AsciiShop.jar *.java


:end