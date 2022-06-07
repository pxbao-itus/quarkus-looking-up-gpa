package com.tma.pxbao.repository.subject;

import com.tma.pxbao.entity.Subject;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SubjectRepository implements PanacheRepository<Subject> {

}
