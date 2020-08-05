# Reflections on Hibernate 
* Identifiers: why not use uuid ?

Numerical PK and FK is usually preferred since it takes less space, genertates is more efficient and indexes work better with sequential identifiers


* Identifiers: Identity or Sequence generator types ?

Identity don't work with batch operation during insert (the increment process happens outside of the current running transaction).
The increment process is very efficient since it uses a database internal lightweight locking mechanism as opposed to the more heavyweight transactional course-grain locks. 
https://stackoverflow.com/questions/27697810/hibernate-disabled-insert-batching-when-using-an-identity-identifier-generator

Sequence: work with batching insert operation nad can be optimized to preallocate values.

If we don't using batch insert identity generator should be sufficient. API don't support insert multiple users/addresses in one transaction.


* Mapping: Why not @Embeddable, but @OneToOne

If Account class is marked as @Embeddable in User's class, they will be fetched eagerly (lazy loading gives us more flexibilty during fetching). @OneToOne is much more efficient, because the best-performing JPA associations always rely on the child-side. What's more we can fetch Account lazy, but only with undirectional @OneToOne (bidirectional cause problem with lazy loading).

With undirectional @OneToOne was used @MapId, reducing loaded indexes, saving time during insert (only one index will be generated) and make easy create query.


* Mapping: Why not @ElementCollection and @OneToMany. 

@ElementCollection -> even with @JoinColumn is still less efficient than the bidirectional @OneToMany association.

If BillingAddres and DeliverAddress classes are marked as @Embeddable in User class, they will be fetched eagerly. @ManyToOne and bidirectional @OneToMany is more efficient, because the best-performing JPA associations always rely on the child-side. What's more we can fetch lazy ?
