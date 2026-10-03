"""Keep documentation recipes identical to their compiled Android host examples."""

from pathlib import Path
import re
import unittest


class RecipeDocumentationTest(unittest.TestCase):
    def test_recipes_match_compiled_examples(self):
        root = Path(__file__).resolve().parents[2]
        source = (root / "android/src/androidHostTest/kotlin/br/com/arch/toolkit/android"
                  / "examples/UsageRecipesTest.kt").read_text(encoding="utf-8")
        document = (root / "docs/recipes.md").read_text(encoding="utf-8")
        recipes = re.findall(r"```kotlin\n(.*?)```", document, re.DOTALL)
        self.assertEqual(4, len(recipes), "Expected lifecycle, state, lists and preferences")
        for index, recipe in enumerate(recipes):
            with self.subTest(recipe=index + 1):
                lines = recipe.splitlines()
                for line in lines:
                    if line.startswith("import "):
                        self.assertIn(line, source)
                body = "\n".join(line for line in lines if not line.startswith("import ")).strip()
                self.assertIn(body, source)


if __name__ == "__main__":
    unittest.main()
