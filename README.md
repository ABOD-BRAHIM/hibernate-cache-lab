## Optimisation des performances avec Hibernate et JPA

### 1. Classe principale de l'application

La classe `App` initialise les données et lance les différents tests de performance afin de comparer trois approches : le chargement sans cache, l'utilisation de `JOIN FETCH` et le cache de second niveau.

![Classe principale App](screnshot/Capture%20d%27%C3%A9cran%202026-10-19%20001548.png)

### 2. Test de performance sans cache

La classe `PerformanceTestService` contient la méthode `testPerformanceSansCache`, qui mesure le temps d'exécution et permet d'observer le problème du chargement des collections associées, notamment le problème des requêtes N+1.

![PerformanceTestService](screnshot/Capture%20d%27%C3%A9cran%202026-10-19%20001633.png)

### 3. Configuration du cache avec Ehcache

Le fichier `ehcache.xml` définit les stratégies de mise en cache, ainsi que les durées d'expiration (*Time To Live — TTL*) appliquées aux entités et aux collections associées.

![Configuration Ehcache](screnshot/Capture%20d%27%C3%A9cran%202026-10-19%20001653.png)

### 4. Configuration JPA et Hibernate

Le fichier `persistence.xml` configure le cache de second niveau, le cache des requêtes et la collecte des statistiques Hibernate afin de faciliter l'analyse des performances.

![Configuration persistence.xml](screnshot/Capture%20d%27%C3%A9cran%202026-10-19%20001703.png)

### 5. Résultats des tests de performance

La console affiche les requêtes SQL générées et les temps d'exécution mesurés. Ces résultats permettent de comparer les différentes approches et d'évaluer l'impact de `JOIN FETCH` et du cache de second niveau sur les performances de l'application.

![Résultats des tests de performance](screnshot/Capture%20d%27%C3%A9cran%202026-10-19%20001736.png)