## How to write glossaries in latex
### Definition
Define your term like this:
```latex
\newglossaryentry{latex}
{
    name=latex,
    description={Is a mark up language specially suited
    for scientific documents}
}
```

### Entries
Mark your entries with:
```latex
\gls{latex}
```

They will appear in the generated glossary.
For an example see [glossary.tex](./doc/task02/glossary.tex)
