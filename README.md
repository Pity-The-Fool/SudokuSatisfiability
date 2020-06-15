# SudokuSatisfiability

### Description:
    This is a Java GUI application that uses sbsat SAT-solver to quickly solve a sudoku
    input by the user.

### Requirements:

    sudo apt install bison flex help2man

**Download and Install SBSAT**
    Download sbsat at: http://gauss.ececs.uc.edu/sbsat-2.7b.tar.gz
    tar xfz sbsat-2.7b.tar.gz
    cd sbsat-2.7b
    ./configure
    make
    make check
    make install

### Build and Run:
    make
    java SudokuSolver
