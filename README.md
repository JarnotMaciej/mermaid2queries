# mermaid2queries

![GitHub](https://img.shields.io/github/license/JarnotMaciej/mermaid2queries?style=flat-square) ![GitHub](https://img.shields.io/github/languages/top/JarnotMaciej/mermaid2queries?style=flat-square) ![GitHub](https://img.shields.io/github/languages/code-size/JarnotMaciej/mermaid2queries?style=flat-square) 

## Short description

mermaid2queries is ~~currently~~ a console application written in Java that follows the MVC (Model-View-Controller) pattern. It converts Mermaid.js input into SQL queries for PostgreSQL.

## Installation

- Clone this repository to your local machine.
- Ensure you have Java installed on your system.
- Compile the Java files using your preferred Java compiler.

## Usage instruction

- Navigate to the directory where you cloned the repository.
- Run the application from the command line with the following command:

`java Main [options]`

Replace `[options]` with any of the following:

- No options: Uses default input and output file paths (`input.txt` and `output.txt` respectively).
- `-i inputFilePath`: Specifies a custom input file path.
- `-o outputFilePath`: Specifies a custom output file path.
- `-i inputFilePath -o outputFilePath`: Specifies both custom input and output file paths.

Example usage:

`java Main -i current/path/input.txt -o current/path/output.txt`

The program will read the Mermaid.js input from the specified input file, generate SQL queries, and save them to the specified output file.

Note: This application is currently a **work in progress**
