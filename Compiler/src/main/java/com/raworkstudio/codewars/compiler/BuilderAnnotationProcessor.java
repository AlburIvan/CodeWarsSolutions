package com.raworkstudio.codewars.compiler;

import com.raworkstudio.codewars.annotations.Builder;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Ivan Alburquerque on 5/10/2017.
 */
@SupportedAnnotationTypes("com.raworkstudio.codewars.annotations.Builder")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public final class BuilderAnnotationProcessor extends AbstractProcessor {


    ProcessingEnvironment processingEnvironment;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        this.processingEnvironment = processingEnv;
    }

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

                    final String className = typeElement.getSimpleName() + "Builder";
                    

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


                    javaFile.writeTo(processingEnvironment.getFiler());

                } catch( IOException ex ) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return true;
    }
}
