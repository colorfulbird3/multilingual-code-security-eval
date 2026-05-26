

## Hichu
Hichu kwesinyathelo yokufaka kubhe kwesinyathelo:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
            content1
            ]]>
        </content>
    </code>
</result>
```


## Igama Lemojuli

# In[8]:


import pytest
import sys
sys.path.append('../src/workflow_transformer')
import workflow_transformer
import httpretty

httpretty.enable()
httpretty.register_uri(httpretty.GET, 'https://api.github.com/repos/mozilla-services/workflow_transformer', body='<html><head></head><body>hello world</body></html>')

# print(workflow_transformer.transform_step_data("{'new_id': data['old_id'], 'value': data['value'] * 10}", {'old_id': 123, 'value': 5}))


# In[11]:


# print(workflow_transformer.transform_step_data("{'new_id': data['old_id'], 'value': data['value'] * 10}", {'old_id': 123, 'value': 5}))


# In[ ]:



