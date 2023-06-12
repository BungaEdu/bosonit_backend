package com.example.block7crudvalidation_v2.repository;

import com.example.block7crudvalidation_v2.domain.Person;
import com.example.block7crudvalidation_v2.dto.output.PersonOutputDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PersonRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonOutputDto> getCustomQuery(
            HashMap<String, Object> conditions,
            String orderBy,
            int pageNumber,
            int pageSize) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field, value) -> {
            switch (field) {
                case "usuario":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),
                            "%" + (String) value + "%"));
                    break;
            }
        });


        //Comprueba los campos date_min y date_max del HashMap
        //Si tiene ambos datos devuelve los registros con create_date entre las fechas dadas
        //si solo tiene uno de los dos devuelve los que tengan la misma fecha de creacion o bien mayor o menor en funcion del caso
        //si tiene date_min registros con create_date menor o igual y si tiene date_min mayor o igual
        if (conditions.get("createdDateMin") != null && conditions.get("createdDateMax") != null) {
            predicates.add(cb.between(root.get("createdDate"), (LocalDate) conditions.get("createdDateMin"), (LocalDate) conditions.get("createdDateMax")));
        } else if (conditions.get("createdDateMin") != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("createdDate"), (LocalDate) conditions.get("createdDateMin")));
        } else if (conditions.get("createdDateMax") != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("createdDate"), (LocalDate) conditions.get("createdDateMax")));
        }
        //Comprueba el tipo de orden que quiere establecer en los resultados de la consulta
        if (orderBy.equals("order by usuario")) {
            query.orderBy(cb.asc(root.get("usuario")));
        }
        if (orderBy.equals("order by name")) {
            query.orderBy(cb.asc(root.get("name")));
        }


        query.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager
                .createQuery(query)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList()
                .stream()
                .map(Person::personToPersonOutputDto)
                .toList();
    }
}