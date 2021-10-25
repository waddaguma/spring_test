package com.example.demo.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTargetMember is a Querydsl query type for TargetMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTargetMember extends EntityPathBase<TargetMember> {

    private static final long serialVersionUID = -577157573L;

    public static final QTargetMember targetMember = new QTargetMember("targetMember");

    public final StringPath active = createString("active");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath zipcode = createString("zipcode");

    public QTargetMember(String variable) {
        super(TargetMember.class, forVariable(variable));
    }

    public QTargetMember(Path<? extends TargetMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTargetMember(PathMetadata metadata) {
        super(TargetMember.class, metadata);
    }

}

