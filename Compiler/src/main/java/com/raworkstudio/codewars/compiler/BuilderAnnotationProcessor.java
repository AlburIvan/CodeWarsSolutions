package com.raworkstudio.codewars.compiler;

import com.raworkstudio.codewars.annotations.Builder;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Ivan Alburquerque on 5/10/2017.
 */
@SupportedAnnotationTypes("com.raworkstudio.codewars.annotations.Builder")
public final class BuilderAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

//        what we're going to build
//
//        Person person = new PersonBuilder.Builder()
//                .withName("Freddin")
//                .withLastName("Alcantara")
//                .withAge(21)
//                .decideGender()
//                .build();

        for( final Element element: roundEnv.getElementsAnnotatedWith( Builder.class ) ) {

            if( element instanceof TypeElement ) {
                final TypeElement typeElement = (TypeElement)element;
                final PackageElement packageElement =
                        ( PackageElement )typeElement.getEnclosingElement();

                try {

                    final String className = typeElement.getSimpleName() + "$$Builder";
                    final JavaFileObject fileObject = processingEnv.getFiler().createSourceFile(
                            packageElement.getQualifiedName() + "." + className);

                    System.out.println(className);

                    // JavaPoet new class
                    MethodSpec main = MethodSpec.methodBuilder("main")
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                            .returns(void.class)
                            .addParameter(String[].class, "args")
                            .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                            .build();

                    TypeSpec helloWorld = TypeSpec.classBuilder(className)
                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                            .addMethod(main)
                            .build();

                    JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                            .build();

                    javaFile.writeTo(fileObject.openWriter());

                } catch( IOException ex ) {
                    System.out.println(ex.getMessage());
                }
            }
        }


      /*  Collection<? extends Element> annotatedElements =
                roundEnv.getElementsAnnotatedWith(Builder.class);
        List<TypeElement> types =
                new ImmutableList.Builder<TypeElement>()
                        .addAll(ElementFilter.typesIn(annotatedElements))
                        .build();

        for (TypeElement type : types) {
            processType(type);
        }*/

        // We are the only ones handling AutoParcel annotations
        return true;
    }

//    private void processType(TypeElement type) {
//        String className = generatedSubclassName(type);
//        String source = generateClass(type, className);
//        writeSourceFile(className, source, type);
//    }

//    private void writeSourceFile(
//            String className,
//            String text,
//            TypeElement originatingType) {
//        try {
//            JavaFileObject sourceFile =
//                    processingEnv.getFiler().
//                            createSourceFile(className, originatingType);
//            Writer writer = sourceFile.openWriter();
//            try {
//                writer.write(text);
//            } finally {
//                writer.close();
//            }
//        } catch (IOException e) {// silent}
//        }
//    }
}
