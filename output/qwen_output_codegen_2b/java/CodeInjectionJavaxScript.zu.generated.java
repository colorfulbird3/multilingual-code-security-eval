 <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
package com.example.repository;

import com.example.model.Metric;

import java.util.List;

public interface MetricRepository {

    Metric findById(Long id);

    List<Metric> findByName(String name);

    Metric save(Metric metric);

}
