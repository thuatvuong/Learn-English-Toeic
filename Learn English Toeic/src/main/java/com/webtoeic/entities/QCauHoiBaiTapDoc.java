package com.webtoeic.entities;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCauHoiBaiTapDoc extends EntityPathBase<CauHoiBaiTapDoc> {

    private static final long serialVersionUID = 712700984L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCauHoiBaiTapDoc cauHoiBaiTapDoc = new QCauHoiBaiTapDoc("cauHoiBaiTapDoc");

    public final QBaiTapDoc baiTapDoc;

    public final StringPath cauHoi = createString("cauHoi");

    public final StringPath dapAn_1 = createString("dapAn_1");

    public final StringPath dapAn_2 = createString("dapAn_2");

    public final StringPath dapAn_3 = createString("dapAn_3");

    public final StringPath dapAn_4 = createString("dapAn_4");

    public final StringPath dapAnDung = createString("dapAnDung");

    public final StringPath giaiThich = createString("giaiThich");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath paragraph = createString("paragraph");

    public final StringPath soThuTu = createString("soThuTu");

    public QCauHoiBaiTapDoc(String variable) {
        this(CauHoiBaiTapDoc.class, forVariable(variable), INITS);
    }

    public QCauHoiBaiTapDoc(Path<? extends CauHoiBaiTapDoc> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCauHoiBaiTapDoc(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCauHoiBaiTapDoc(PathMetadata metadata, PathInits inits) {
        this(CauHoiBaiTapDoc.class, metadata, inits);
    }

    public QCauHoiBaiTapDoc(Class<? extends CauHoiBaiTapDoc> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.baiTapDoc = inits.isInitialized("baiTapDoc") ? new QBaiTapDoc(forProperty("baiTapDoc")) : null;
    }
}
