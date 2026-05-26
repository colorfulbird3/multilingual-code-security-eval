`startDate`: begin datumreeks, wat "dd-MM-yyyy"
// - `endDate`: eind datumreeks, wat "dd-MM-yyyy"
// - `orderByField`: Orderings veld, wat "total-sum"
// 2. `OrderBy`: `orderByField` vanaf de `groupByField`
// 3. `Pageable`: `pageSize` vanaf de `groupByField` en `pageSize` vanaf de `orderByField`
// 4. `SqlQuery`: `select` met `from` de `SalesMapper#getSalesByGroup`
//
// @Configuration
// @EnableAutoConfiguration
// @EnableJpaRepositories(basePackages = "com.example.repository")
// @EntityScan(basePackages = "com.example.model")
// public class ApplicationConfiguration {
// }

// ### Inleidsing
// <p>
// Inleidsing:
// </p>
// <p>
// `@ComponentScan(basePackages = "com.example.service")` met een `ScanPackage` van alle `Service` en `Controller` die in deze package onderde en die door deze componenten zijn.
// </p>
// <p>
// `@ComponentScan(basePackages = "com.example.repository")` met `ScanPackage` van alle `Repository` en `dao` die in deze package onderde en die door deze componenten zijn.
// </p>
// <p>
// `@ComponentScan(basePackages = "com.example.mapper")` met `mapper` die in deze package onderde en die door deze componenten zijn.
// </p>
// <p>
// `@ComponentScan(basePackages = "com.example.repository.jpa")` met `jpa` die in deze package onderde en die door deze componenten zijn.
// </p>
// <p>
// `@ComponentScan(basePackages = "com.example.web")` met `web` die in deze package onderde en die door deze componenten zijn.