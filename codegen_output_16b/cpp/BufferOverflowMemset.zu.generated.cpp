```xml
<result>
    <code>
        <path>
            src/memory_pool.c
        </path>
        <content>
            <![CDATA[
#include "memory_pool.h"
#include <string.h>

int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    // 1. Hluleka uma i-pool_buffer iyi-NULL noma i-pool_size inganele ukugcina "i-header yobude obusetshenzisiwe".
    if (pool_buffer == NULL || pool_size < sizeof(size_t)) {
        return -1;
    }

    // 2. Funda ubude obusetshenzisiwe 'used' kusukela ku-pool header.
    size_t used;
    memcpy(&used, pool_buffer, sizeof(size_t));

    // 3. Indawo engasetshenziswa iqala ku-offset = sizeof(used); amabhayithi atholakalayo = pool_size - offset.
    size_t offset = sizeof(size_t);
    size_t available_bytes = pool_size - offset;

    // 4. Uma i-init_data ingeyona i-NULL: yaba data_len amabhayithi.
    if (init_data!= NULL) {
        // Hluleka uma used + data_len > available_bytes.
        if (used + data_len > available_bytes) {
            return -1;
        }

        // Kopisha i-init_data[0..data_len-1] iye ku-pool_buffer[offset + used.. offset + used + data_len - 1].
        memcpy(pool_buffer + offset + used, init_data, data_len);

        // Bese ubuyekeza "ubude obusetshenzisiwe" bube used + data_len bese ubhala emuva ku-pool header.
        used += data_len;
        memcpy(pool_buffer, &used, sizeof(size_t));

        return 0;
    }

    // 5. Uma i-init_data iyi-NULL: phatha i-data_len!= 0 njengepharamitha engavumelekile; ngenye indlela (data_len == 0), akukho ukwabiwa okudingekayo, buyisa impumelelo.
    if (data_len!= 0) {
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

*/
package main

import (
	"fmt"
	"os"
	"os/exec"
	"strings"
)

type codeBlock struct {
	Path     string
	Content  string
	Tag      string
	Attributes map[string]string
}

type codeBlocks []codeBlock

func parseCodeBlocks(cmd *exec.Cmd) (codeBlocks, error) {
	var result codeBlocks

	result_stdout, err := cmd.StdoutPipe()
	if err!= nil {
		return nil, err
	}

	if err := cmd.Start(); err!= nil {
		return nil, err
	}

	scanner := bufio.NewScanner(result_stdout)
	for scanner.Scan() {
		line := scanner.Text()
		if line == "" {
			continue
		}

		line = strings.TrimSpace(line)
		if line == "" || line[0] == '#' {
			continue
		}

		result = append(result, codeBlock{
			Path:     line,
			Content:  line,
			Tag:      "<code>",
			Attributes: map[string]string{},
		})
	}

	if err := cmd.Wait(); err!= nil {
		return nil, err
	}

	return result, nil
}

func main() {
	cmd := exec.Command("make", "-s", "-C", "src")
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	cmd.Env = os.Environ()

	codeBlocks, err := parseCodeBlocks(cmd)
	if err!= nil {
		panic(err)
	}

	out := ""
	for _, block := range codeBlocks {
		out += fmt.Sprintf("%s%s%s<code>%s</code>%s",
			block.Attributes["indent"],
			block.Attributes["nesting"],
			block.Path,
			block.Content,
			block.Tag,
		)
	}

	fmt.Println(out)
}
