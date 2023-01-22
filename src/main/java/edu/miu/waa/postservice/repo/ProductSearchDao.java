package edu.miu.waa.postservice.repo;

import edu.miu.waa.postservice.domain.dto.request.CriteriaRequestDto;
import edu.miu.waa.postservice.domain.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductSearchDao {

    private final EntityManager entityManager;

    public List<Post> findAllByCriteria(CriteriaRequestDto criteriaRequestDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        List<Predicate> predicates = new ArrayList<>();

        // select from Post
        Root<Post> root = criteriaQuery.from(Post.class);
        if (criteriaRequestDto.getTitle() != null) {
            Predicate titlePredicate = criteriaBuilder.like(root.get("title"), "%" + criteriaRequestDto.getTitle() + "%");
            predicates.add(titlePredicate);
        }
        criteriaQuery.where(
                criteriaBuilder.or(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
