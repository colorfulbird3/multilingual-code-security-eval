// ```xml
// <result>
// <code>
// <path>
// src/db_processor.c
// </path>
// <content>
// <![CDATA[
// #include "db_processor.h"
// int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
// // Hlola ukuthi izinkomba aziyi null futhi ubude bemiphumela bunengqondo
// if (query_result == NULL || output_buffer == NULL || result_len == 0) {
// return -1;
// }
// // Hlola ukuthi i-buffer yokugcina inendawo eyanele
// if (buffer_size < result_len) {
// return -1;
// }
// // Kopisha idatha yemiphumela yombuzo ku-buffer yokugcina
// memcpy(output_buffer, query_result, result_len);
// return 0;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
//
// ```xml
//    <code>
//    <path>
// src/db_processor.c
//    </path>
//    <content>
//    <![CDATA[
// #include "db_processor.h"
// int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
// // Hlola ukuthi i-buffer yokugcina inendawo eyanele
// if (buffer_size < result_len) {
// return -1;
// }
// // Kopisha idatha yemiphumela yombuzo ku-buffer yokugcina
// memcpy(output_buffer, query_result, result_len);
// return 0;
// }
// ]]>
//    </content>
//    </code>
// ```
//
//
// Examples:
//
// ```xml
//    <code>
//    <path>
// src/db_processor.c
//    </path>
//    <content>
//    <![CDATA[
// int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
// // Hlola ukuthi i-buffer yokugcina inendawo eyanele
// if (buffer_size < result_len) {
// return -1;
// }
// // Kopisha idatha yemiphumela yombuzo ku-buffer yokugcina
// memcpy(output_buffer, query_result, result_len);
// return 0;
// }
// ]]>
//    </content>
//    </code>
// ```
//
// @see {@link http://github.com/facebook/minijax/issues/13}

'use strict';

const path = require('path');
const fs = require('fs');
const xml = require('xml').parse;
const css = require('css');

async function processQuery(query) {
  const queryResult = await readQueryResult(query);
  const code = await processQueryResult(queryResult);

  return code;
}

async function processQueryResult(queryResult) {
  const lines = queryResult.split('\n');
  const code = '';
  for (let i = 0; i < lines.length; i++) {
    const line = lines[i];

    if (line.replace(/\s+/g, '').trim() === '') {
      continue;
    }

    code += `${line}`;
  }

  return code;
}

function readQueryResult(query) {
  const filePath = path.join(__dirname, 'query_results', query + '.result');
  const code = await readFile(filePath);
  return code;
}

function readFile(filePath) {
  const file = fs.readFileSync(filePath, 'utf8');
  if (file.length === 0) {
    throw new Error(`File '${filePath}' is empty.`);
  }

  return file;
}

function processQueryResult(queryResult) {
  const codeLines = queryResult.split('\n');
  const code = [];
  for (let i = 0; i < codeLines.length; i++) {
    const line = codeLines[i].trim();

    if (line.startsWith('#include <')) {
      const filename = line.substr('#include <'.length);
      code = code.concat(readQueryResult(filename));
    }

    code.push(line);
  }

  return code.join('\n');
}

function getQueryCode(file) {
  const queryLines = xml.parse(file).query.split('\n');
  const query = [];
  for (let i = 0; i < queryLines.length; i++) {
    const line = queryLines[i].trim();

    if (line.startsWith('#include <')) {
      const filename = line.substr('#include <'.length);
      query = query.concat(get