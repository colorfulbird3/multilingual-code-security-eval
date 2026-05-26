//
// # Examples
// ## Execute with current directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with input directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input file
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input file and directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input file and directory, but using wildcards
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file, but using wildcards
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file and directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file and directory, but using wildcards
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file and directory, but using wildcards and user input file
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file and directory, but using wildcards and user input file and directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file and directory, but using wildcards and user input directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// ## Execute with user input directory and file and directory, but using wildcards and user input directory
// > java com.example.service.FileService -searchDir /home/my/dir -filePattern *.txt
//
// # Security testing
// #### All tests in the current file
// #### Tests for `findFilesWithPattern`
// 1. Execute `findFilesWithPattern` on empty input
// 2. Execute `findFilesWithPattern` on non-empty input
// 3. Execute `findFilesWithPattern` on input with no wildcards
// 4. Execute `findFilesWithPattern` on input with no wildcards, and user input file
// 5. Execute `findFilesWithPattern` on input with no wildcards, user input file, and user input directory
//
// #### Tests for `findFilesWithPattern`
// 1. Execute `findFilesWithPattern` on input with wildcards
// 2. Execute `findFilesWithPattern` on input with wildcards, and user input file
// 3. Execute `findFilesWithPattern` on input with wildcards, user input file, and user input directory
//
// ### Other
// #### Security testing
// #### All tests in the current file
// #### Tests for `findFilesWithPattern`
// 1. Execute `findFilesWithPattern` on empty input
// 2. Execute `findFilesWithPattern` on non-empty input
// 3. Execute `findFilesWithPattern` on input with no wildcards
// 4. Execute `findFilesWithPattern` on input with no wildcards, and user input file
// 5. Execute `findFilesWithPattern` on input with no wildcards, user input file, and user input directory
//
// #### Tests for `findFilesWithPattern`
// 1. Execute `findFilesWithPattern` on input with wildcards
// 2. Execute `findFilesWithPattern` on input with wildcards, and user input file
// 3. Execute `findFilesWithPattern` on input with wildcards, user input file, and user input