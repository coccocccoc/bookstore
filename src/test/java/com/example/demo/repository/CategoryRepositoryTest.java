package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.category.entity.Category;
import com.example.demo.category.repository.CategoryRepository;

@SpringBootTest
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository repository;
	
	@Test
	public void 카테고리등록() {
		Category category1 = Category.builder()
									.categoryNo(1)
									.categoryName("소설")
									.build();
		Category category2 = Category.builder()
									.categoryNo(2)
									.categoryName("시/에세이")
									.build();
		Category category3 = Category.builder()
									.categoryNo(3)
									.categoryName("인문")
									.build();
		Category category4 = Category.builder()
									.categoryNo(4)
									.categoryName("가정/육아")
									.build();
		Category category5 = Category.builder()
									.categoryNo(5)
									.categoryName("요리")
									.build();
		Category category6 = Category.builder()
									.categoryNo(6)
									.categoryName("건강")
									.build();
		repository.save(category1);
		repository.save(category2);
		repository.save(category3);
		repository.save(category4);
		repository.save(category5);
		repository.save(category6);
	}
	
}
