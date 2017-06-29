# DemoForEhcache

Follow KCP Readme for Business and Address tables
For Items table script
CREATE TABLE public.items
(
    item_id text COLLATE pg_catalog."default" NOT NULL,
    item_name text COLLATE pg_catalog."default" NOT NULL,
    item_desc text COLLATE pg_catalog."default",
    CONSTRAINT item_id_pk PRIMARY KEY (item_id)
)

ArchType
web, JPA, Postgres

Started the pgadming local db

Added Controller for Business and Address and validated

ehCache settings:
added dependency for ehcache and commons-lang3

Added ehCache.xml at proj locatin /src/main/resources

Added Util.java

Added JPA for the table Items:
Items.java (Domain Object)
ItemsRepository.java (DAO Impl)
CacheService.java (Service layer to interact with Repository(DAOImpl), in general you can add all other tables also here)

Added PraCacheManager.java (loaded ehCache.xml)

Added ItemsCacheHandler.java

Insdie get All Businesses controller added ItemsCacheHandler to fetch ItemName by Id
Controller --->  ItemsCacheHandler --->  Service ---> Repository(DAO)  ---> DB

Started the server and validated
In the log you must see the sql to fetch the Items only for 1st get all businesses api request and
in the subsequent calls to the get businesses api request you should not see the hibernate sql to fetch the the items.
